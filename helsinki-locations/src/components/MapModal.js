import React, { Component } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMapMarkedAlt } from "@fortawesome/free-solid-svg-icons";
import Modal from "./Modal";

class MapModal extends Component {
  constructor() {
    super();
    this.state = {
      show: false,
      defaultLocation: {
        lat: "60",
        lng: "25",
      },
    };
    this.showModal = this.showModal.bind(this);
    this.hideModal = this.hideModal.bind(this);
  }

  showModal = () => {
    this.setState({
      show: true,
      defaultLocation: {
        lat: this.props.defaultLocation.lat,
        lng: this.props.defaultLocation.lng,
      },
    });
  };

  hideModal = () => {
    this.setState({ show: false });
  };
  render() {
    return (
      <>
        <Modal
          show={this.state.show}
          handleClose={this.hideModal}
          defaultLocation={this.props.defaultLocation}
        ></Modal>
        <p>
          <FontAwesomeIcon
            icon={faMapMarkedAlt}
            onClick={this.showModal}
          ></FontAwesomeIcon>
        </p>
      </>
    );
  }
}
export default MapModal;
