import Carousel from 'react-bootstrap/Carousel';
import ExampleCarouselImage from 'components/ExampleCarouselImage';


function CarouselFadeExample() {
    return (
        <Carousel fade>
            <Carousel.Item>
                <ExampleCarouselImage text="VGA" />
                <Carousel.Caption>
                    <h3>RTX 2080Ti ~ RTX 4090</h3>
                    <p>보급형부터 초고스펙까지 다양한 사양의 그래픽 카드를 골라보세요!</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <ExampleCarouselImage text="MangBear" />
                <Carousel.Caption>
                    <h3>극강의 귀여움 망곰</h3>
                    <p>당신만의 망곰을 찾아보세요!</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <ExampleCarouselImage text="Fitness" />
                <Carousel.Caption>
                    <h3>건강만큼 중요한 것은 없습니다!</h3>
                    <p>
                        다양한 운동기구를 바로 이곳에서 만나보세요!
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
}

export default CarouselFadeExample;