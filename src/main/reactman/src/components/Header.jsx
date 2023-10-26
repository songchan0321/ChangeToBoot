import React, { useState } from "react";

const headerNav = [
    {
        title: "login",
        url: "https://kauth.kakao.com/oauth/authorize?client_id=d4902b679b4cb9882b0b671908630d39&redirect_uri=http://localhost:3000/auth&response_type=code"
    },
    {
        title: "main",
        url: "#intro"
    },
    {
        title: "object",
        url: "#skill"
    },
    {
        title: "products",
        url: "#site"
    },
    {
        title: "best items",
        url: "#port"
    },
    {
        title: "customer service",
        url: "#contact"
    }
];

const Header = () => {
    const [show, setShow] = useState(false);

    const toggleMenu = () => {
        setShow((prevShow) => !prevShow);
    };

    return (
        <header id="header" role="banner">
            <div className="header__inner">
                <div className="header__logo">
                    <a href="/">Chan Store<em>fashion</em></a>
                </div>
                <nav className={`header__nav ${show ? "show" : ""}`} role="navigation" aria-label="메인 메뉴">
                    <ul>
                        {headerNav.map((nav, key) => (
                            <li key={key}>
                                <a href={nav.url}>{nav.title}</a>
                            </li>
                        ))}
                    </ul>
                </nav>
                <div
                    className="header__nav__mobile"
                    id="headerToggle"
                    aria-controls="primary-menu"
                    aria-expanded={show ? "true" : "false"}
                    role="button"
                    tabIndex="0"
                    onClick={toggleMenu}
                >
                    <span></span>
                </div>
            </div>
        </header>
    );
};

export default Header;