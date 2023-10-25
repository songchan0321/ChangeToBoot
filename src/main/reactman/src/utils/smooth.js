import Lenis from "@studio-freight/lenis"; //스크롤 애니메이션 구현

const lenis = () => {
    const lenis = new Lenis({
        duration: 1,
        easing: (t) => Math.min(1, 1.001 - Math.pow(2, -10 * t))
    });

    function raf(time) {
        lenis.raf(time)
        requestAnimationFrame(raf); //애니메이션 부드럽게 업데이트
    }

    requestAnimationFrame(raf);

    lenis.on("scroll", (e) => {
        console.log(e);
    })
}

export default lenis;