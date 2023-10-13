import React from "react";


const contactText = [
    {
        link: "https://github.com/songchan0321",
        title: "github : https://github.com/songchan0321",
    },
    {
        link: "mailto:mysticsong@naver.com",
        title: "mail : mysticsong@naver.com",
    },
];
const Contact = () => {
    return <div className="contact__text">
        <div className="text">
            {contactText.map((contact, key) => (
                <div key={key}>
                    <a
                        href={contact.link}
                        rel="noopener noreferrer"
                        target="_blank"
                    >
                        {contact.title}
                    </a>
                </div>
            ))}
        </div>
    </div>;

};

export default Contact;