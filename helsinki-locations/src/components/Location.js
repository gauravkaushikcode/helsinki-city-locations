import React, { Component } from "react";
import moment from "moment";

import { Table } from "reactstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSortUp, faSortDown } from "@fortawesome/free-solid-svg-icons";

import LocationHeader from "./LocationHeader";
import LocationBlank from "./LocationNotFound";
import baseURL from "../constant/network.constant";
import Pagination from "./Pagination";
import MapModal from "./MapModal";
class Location extends Component {
  constructor(props) {
    super(props);

    let today = moment(),
      time = moment(today).format("HH:mm:ss"),
      day = today.day();

    this.state = {
      addLocationError: false,
      addLocationErrorMsg: "",
      locationList: [],
      holdAllLocationList: [],
      options: {
        limit: 10,
        page: 1,
        totalCount: 0,
      },
      sortName: undefined,
      sortOrder: "asc",
      currentTime: time,
      currentDay: day,
    };
  }
  getUpdatedLocationList(holdAllLocationList) {
    let totalCount = holdAllLocationList.length,
      { limit, page } = this.state.options,
      start = limit * page - limit,
      end = start + limit,
      locationList = holdAllLocationList.slice(start, end);
    if (!locationList.length) {
      page = page - 1 || 1;
      start = limit * page - limit;
      end = start + limit;
      locationList = holdAllLocationList.slice(start, end);
    }
    return {
      locationList,
      totalCount,
      page,
    };
  }

  // when component is mounting call to backend API
  componentDidMount() {
    let myRequest = new Request(`${baseURL}/locations/`, {
      headers: { "Content-Type": "application/json; charset=utf-8" },
      method: "GET",
    });
    fetch(myRequest)
      .then((res) => res.json())
      .then((response) => {
        //add pagination option
        const holdAllLocationList = response,
          { locationList, totalCount, page } = this.getUpdatedLocationList(
            holdAllLocationList
          );
        if (totalCount) {
          this.setState((prev) => {
            return {
              holdAllLocationList,
              locationList,
              options: {
                ...prev.options,
                totalCount,
                page,
              },
            };
          });
        }
      });
  }
  onChange(data) {
    const {
        options: { limit: preLimit, page: prePage },
        holdAllLocationList,
      } = this.state,
      { limit = preLimit, page = prePage } = data,
      start = limit * page - limit,
      end = start + limit,
      locationList = holdAllLocationList.slice(start, end);
    this.setState({
      locationList,
      options: Object.assign(this.state.options, data),
    });
  }

  sortData(column) {
    let {
        holdAllLocationList,
        sortOrder,
        sortName,
        options: { limit, page },
      } = this.state,
      order = "asc",
      orderBy = sortName || column;

    if (sortName === column) {
      order = sortOrder === "asc" ? "dsc" : "asc";
    } else {
      orderBy = column;
    }

    let sortedData = holdAllLocationList.sort((a, b) => {
      const bandA = column === "id" ? a[column] : a[column].toUpperCase();
      const bandB = column === "id" ? b[column] : b[column].toUpperCase();
      let comparison = 0;
      if (bandA > bandB) {
        comparison = 1;
      } else if (bandA < bandB) {
        comparison = -1;
      }
      if (order === "asc") {
        return comparison;
      } else {
        return comparison * -1;
      }
    });

    const start = limit * page - limit,
      end = start + limit,
      locationList = holdAllLocationList.slice(start, end);

    this.setState({
      holdAllLocationList: sortedData,
      sortName: orderBy,
      sortOrder: order,
      locationList,
    });
  }
  render() {
    let {
      location,
      locationList,
      addLocationError,
      addLocationErrorMsg,
      options,
      sortName,
      sortOrder,
    } = this.state;
    return (
      <>
        <LocationHeader
          locationData={location}
          addLocationError={addLocationError}
          addLocationErrorMsg={addLocationErrorMsg}
        />
        {
          <Table responsive className="location-table">
            <thead>
              <tr>
                <th onClick={this.sortData.bind(this, "id")}>
                  Location Id
                  {sortName === "id" && (
                    <FontAwesomeIcon
                      className="sort-icon up"
                      icon={sortOrder === "asc" ? faSortUp : faSortDown}
                      title="sort"
                    ></FontAwesomeIcon>
                  )}
                </th>

                <th>Location Name</th>
                <th>Address</th>
                <th>Locate on Map</th>
                <th>Open/Close</th>
              </tr>
            </thead>
            <tbody>
              {locationList.map(({ id, name, location, opening_hours }) => (
                <tr key={id}>
                  <td>
                    <span className="round">{id}</span>
                  </td>
                  <td>{name["fi"]}</td>
                  <td>
                    {location["address"]["street_address"]}
                    {", "}
                    {location["address"]["postal_code"]}{" "}
                    {location["address"]["locality"]}
                  </td>
                  <td>
                    <MapModal
                      defaultLocation={{
                        lat: parseFloat(location["lat"]),
                        lng: parseFloat(location["lon"]),
                      }}
                    />
                  </td>
                  <td>
                    {opening_hours["hours"]
                      .filter((hours) => hours !== null)
                      .map(({ weekday_id, opens, closes, open24h }) => {
                        if (
                          this.state.currentDay === weekday_id &&
                          opens != null &&
                          closes != null &&
                          this.state.currentTime > opens &&
                          this.state.currentTime < closes
                        ) {
                          return (
                            <p style={{ color: "green" }}>
                              Open [Timings -- {opens}--{closes}]
                            </p>
                          );
                        } else if (
                          this.state.currentDay === weekday_id &&
                          open24h === true
                        ) {
                          return <p style={{ color: "blue" }}>Open 24H</p>;
                        } else if (this.state.currentDay === weekday_id) {
                          return (
                            <p key={weekday_id++} style={{ color: "red" }}>
                              Closed [Timings -- {opens}--{closes}]
                            </p>
                          );
                        }
                        return null;
                      })}
                    <i style={{ whiteSpace: "pre-wrap", color: "grey" }}>
                      {opening_hours["openinghours_exception"]}
                    </i>
                  </td>
                </tr>
              ))}
            </tbody>

            <tfoot>
              <Pagination options={options} onChange={this.onChange.bind(this)}>
                {" "}
              </Pagination>
            </tfoot>
          </Table>
        }
        {!locationList.length && (
          <LocationBlank
            heading="Kindly Wait"
            subHeading="Locations are loading"
          ></LocationBlank>
        )}
      </>
    );
  }
}

export default Location;
