import React, {useEffect, useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import HomeView from "./views/HomeView";
import smooth from "./utils/smooth";
import link from "./utils/link";

const App = () => {
    useEffect(() => {
        smooth();
        link();
    }, []);
    const [loading, setLoading] = useState(true);

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomeView />} />
            </Routes>
        </BrowserRouter>

    );
};

export default App;