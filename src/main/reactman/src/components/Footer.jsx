import React from "react";

const footerText = [
    {
        title: "github",
        desc: "다양하지 않은 소스를 구경해보세요.",
        link: "https://github.com/songchan0321",
    },
    {
        title: "blog",
        desc: "보잘것 없는 블로그 입니다.",
        link: "https://chan0321.tistory.com/",
    },
];
const Footer = () => {
    return <div className="right">
        <h3>social</h3>
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