import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Contact from "./components/Contact";
import Footer from "./components/Footer";
import Header from "./components/Header";
import Intro from "./components/Intro";
import Main from "./components/Main";
import Port from "./components/Port";
import Site from "./components/Site";
import Skill from "./components/Skill";
import Skip from "./components/Skip";

const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={Contact} />
                <Route path="/" component={Footer} />
                <Route path="/" component={Header} />
                <Route path="/" component={Intro} />
                <Route path="/" component={Main} />
                <Route path="/" component={Port} />
                <Route path="/" component={Site} />
                <Route path="/" component={Skill} />
                <Route path="/" component={Skip} />
            </Switch>
        </Router>
    );
};

export default Routes;