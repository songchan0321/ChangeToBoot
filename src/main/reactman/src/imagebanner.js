import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Row from 'react-bootstrap/Row';

function ShapeExample(){
    return(
        <Container>
            <Row>
                <Col xs={6} md={4}>
                    <Image src="holder.js/170x180" rounded />
                </Col>
                <Col xs={6} md={4}>
                    <Image src="holder.js/170x180" rounded />
                </Col>
                <Col xs={6} md={4}>
                    <Image src="holder.js/170x180" rounded />
                </Col>
            </Row>
        </Container>
    );
}

export default ShapeExample;