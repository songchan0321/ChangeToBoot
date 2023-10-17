import React from "react";
import port01 from "../assets/img/port01.jpg";
import port02 from "../assets/img/port02.jpg";
import port03 from "../assets/img/port03.jpg";
import port04 from "../assets/img/port04.jpg";

const portText = [
    {
        num: "01",
        title: "Thom Brown 4바 가디건",
        img: port01,
        code: "https://www.musinsa.com/app/goods/3437285",
        view: "https://www.musinsa.com/app/goods/3437285",
        name: "Thom Brown",
    },
    {
        num: "02",
        title: "나이키 에어 포스 1 ’07",
        desc: "빛이 그대로 살아 있는 나이키 에어 포스 1 ’07은 OG 농구화로서 많은 사랑을 받아온 디자인에 새로운 멋을 더했습니다. 튼튼하게 스티치 처리된 오버레이와 깔끔한 마감 처리, 과하지 않은 절제된 화려함으로 빛나는 존재감을 발휘해 보세요.",
        img: port02,
        code: "https://www.nike.com/kr/t/%EC%97%90%EC%96%B4-%ED%8F%AC%EC%8A%A4-1-07-%EB%82%A8%EC%84%B1-%EC%8B%A0%EB%B0%9C-TttlGpDb/CW2288-111?utm_source=Google&utm_medium=PS&utm_campaign=365DIGITAL_Google_SP_pMAX_all_all&utm_term=pMax.af1&cp=31968578260_search_&gclid=Cj0KCQjwsp6pBhCfARIsAD3GZubjF94CIwRtTL9eUMWWi5teTxqVEgmnlGfbm-FHSUyUdOGNEeeuy_UaAo9kEALw_wcB",
        view: "https://www.nike.com/kr/t/%EC%97%90%EC%96%B4-%ED%8F%AC%EC%8A%A4-1-07-%EB%82%A8%EC%84%B1-%EC%8B%A0%EB%B0%9C-TttlGpDb/CW2288-111?utm_source=Google&utm_medium=PS&utm_campaign=365DIGITAL_Google_SP_pMAX_all_all&utm_term=pMax.af1&cp=31968578260_search_&gclid=Cj0KCQjwsp6pBhCfARIsAD3GZubjF94CIwRtTL9eUMWWi5teTxqVEgmnlGfbm-FHSUyUdOGNEeeuy_UaAo9kEALw_wcB",
        name: "Nike",
    },
    {
        num: "03",
        title: "thisisneverthat 맨투맨",
        img: port03,
        code: "https://www.musinsa.com/app/goods/3540245",
        view: "https://www.musinsa.com/app/goods/3540245",
        name: "thisisneverthat",
    },
    {
        num: "04",
        title: "Mardi Mercredi 스웨트셔츠",
        img: port04,
        code: "https://www.musinsa.com/app/goods/1549285",
        view: "https://www.musinsa.com/app/goods/1549285",
        name: "Mardi",
    },
];
const Port = () => {
    return (
        <section id="port">
            <div className="port__inner">
                <div className="port__title">
                    Best Items <em>최고 인기 상품</em>
                </div>
                <div className="port__wrap">
                    {portText.map((port, key) => (
                        <article className={`port__item p${key + 1}`} key={key}>
                            <span className="num">{port.num}.</span>
                            <a href={port.code} target="_blank" className="img" rel="noreferrer">
                                <img src={port.img} alt={port.name} />
                            </a>
                            <h3 className="title">{port.title}</h3>
                            <p className="desc">{port.desc}</p>
                            <a href={port.view} target="_blank" className="site" rel="noreferrer">상품으로 이동</a>
                        </article>
                    ))}
                </div>
            </div>
        </section>
    );
};
export default Port;