import React from "react";
import { shallow } from "enzyme";

import App from "../App";
import Location from "../Location";
let wrappedAppComponent;
beforeEach(() => {
  wrappedAppComponent = shallow(<App />);
});

it("shows location", () => {
  expect(wrappedAppComponent.find(Location).length).toEqual(1);
});
