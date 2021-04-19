import React, { Component } from "react";
import { GoogleMap, Marker } from "@react-google-maps/api";
import "../style/App.scss";
class Map extends Component {
  state = {
    defaultLocation: { lat: 40.756795, lng: -73.954298 },
  };
  render() {
    return (
      <div className="map-padding">
        <h5>
          {this.props.defaultLocation.lat}, {this.props.defaultLocation.lng}
        </h5>
        <GoogleMap
          center={this.props.defaultLocation}
          zoom={15}
          mapContainerStyle={{ height: "400px", width: "800px" }}
        >
          <Marker position={this.props.defaultLocation} />
        </GoogleMap>
      </div>
    );
  }
}
export default Map;
