import React from "react";

const Site = () => {
    const siteText = [
        {
            text: ["Top", "스타일과 편안함을 완벽하게 조화시킨 상의"],
            title: "다양한 브랜드의 상의를 만나보세요",
            Link: "https://www.musinsa.com/app/",
            info: [
                "clothes",
                "top",
            ],
        },
        {
            text: ["Outer", "스타일을 강조한 아우터"],
            title: "모든 계절에 완벽하게 어울리며, 아우터의 새로운 정의를 제시합니다.",
            Link: "https://www.musinsa.com/app/",
            info: [
                "clothes",
                "outer",
            ],
        },
        {
            text: ["Pants", "고급스러운 스타일의 다양한 하의"],
            title: "고급스러운 하의 모음전",
            Link: "https://www.musinsa.com/app/",
            info: [
                "clothes",
                "pants",
            ],
        },
        {
            text: ["Bag", "가방 또한 패션입니다."],
            title: "다양한 브랜드의 가방",
            Link: "https://www.musinsa.com/app/",
            info: [
                "bags",
                "women's and men's",
            ],
        },
    ];
    return (
        <section id="site">
            <div className="site__inner">
                <h2 className="site__title">Products<em>     상품</em></h2>
                <div className="site__wrap">
                    {siteText.map((site, key) => (
                        <article className={`site__item s${key+1}`} key={key}>
                            <span className="num">{key+1}.</span>
                            <div className="text">
                                <div>{site.text[0]}</div>
                                <div>{site.text[1]}</div>
                                <div>{site.text[2]}</div>
                            </div>
                            <h3 className="title">
                                {site.title}
                            </h3>
                            <div className="btn">
                                <a href={site.Link}>Link</a>
                            </div>
                            <div className="info">
                                <span>{site.info[0]}</span>
                                <span>{site.info[1]}</span>
                                <span>{site.info[2]}</span>
                            </div>
                        </article>
                    ))}
                </div>
            </div>
        </section>
    );
};
export default Site;