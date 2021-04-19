import { LoadScript } from "@react-google-maps/api";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faWindowClose } from "@fortawesome/free-solid-svg-icons";
import "../style/Modal.scss";
import Map from "./Map";
const lib = ["places"];
const key = "AIzaSyDhZraldQfqqd2QAFraSywC4X5ID9YG91s";
const Modal = ({ handleClose, show, defaultLocation }) => {
  const showHideClassName = show ? "modal display-block" : "modal display-none";

  return (
    <div className={showHideClassName}>
      <section className="modal-main map-padding ">
        <FontAwesomeIcon
          className="pull-right"
          icon={faWindowClose}
          onClick={handleClose}
        ></FontAwesomeIcon>
        <LoadScript googleMapsApiKey={key} libraries={lib}>
          <Map defaultLocation={defaultLocation} />
        </LoadScript>
      </section>
    </div>
  );
};
export default Modal;
