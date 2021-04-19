import React from "react";
import { mount } from "enzyme";

import App from "../App";
import Location from "../Location";

let wrappedLocationComponent;
beforeEach(() => {
  const initialState = {
    location: ["Location Id", "Location Name", "Address", "Open/Close"],
  };
  wrappedLocationComponent = mount(
    <App>
      <Location initialState={initialState} />
    </App>
  );
});
afterEach(() => {
  wrappedLocationComponent.unmount();
});
it("has a table and pagination in footer", () => {
  expect(wrappedLocationComponent.find("table").length).toEqual(1);
  expect(wrappedLocationComponent.find("thead").length).toEqual(1);
  expect(wrappedLocationComponent.find("tfoot").length).toEqual(1);
});
it("creates one td per location", () => {
  expect(wrappedLocationComponent.find("td").length).toEqual(1);
});
it("shows the text Id, Name, Address and Open/Close for each Location", () => {
  expect(wrappedLocationComponent.render().text()).toContain("Location Id");
  expect(wrappedLocationComponent.render().text()).toContain("Location Name");
  expect(wrappedLocationComponent.render().text()).toContain("Address");
  expect(wrappedLocationComponent.render().text()).toContain("Open/Close");
  expect(wrappedLocationComponent.find("thead").text()).toContain("Open/Close");
});
