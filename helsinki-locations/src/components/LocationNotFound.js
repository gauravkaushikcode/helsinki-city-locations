import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStream } from "@fortawesome/free-solid-svg-icons";
import NoLocation from "../images/no-location.png";

const LocationNotFound = ({ heading = "", subHeading = "" }) => {
  return (
    <div className="d-center">
      <img src={NoLocation} alt="no location"></img>
      <div className="dark">{heading}</div>
      <div className="light small">{subHeading}</div>
      <FontAwesomeIcon icon={faStream}></FontAwesomeIcon>
    </div>
  );
};
export default LocationNotFound;
