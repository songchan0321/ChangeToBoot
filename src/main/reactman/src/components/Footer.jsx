import React from "react";

const footerText = [

];
const Footer = () => {
    return <div className="right">
        <h3></h3>
        <ul>
            {footerText.map((footer, key) => (
                <li key={key}>
                    <a href={footer.link}>{footer.title}</a>
                    <em>{footer.desc}</em>
                </li>
            ))}
        </ul>
    </div>;
};

export default Footer;