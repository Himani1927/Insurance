import { Button, Card, CardGroup, Carousel, Col, Container, Row } from "react-bootstrap";
import Navbar from "../Bar/Navbar";
import { Link } from "@mui/material"
import { Link as RouterLink } from 'react-router-dom';


function Home() {

    return (
        <>
            <Navbar />

            <div className="d-grid gap-3">
                <Container fluid>
                    <Row style={{ marginTop: "25px" }}>

                        <Card>
                            <Col>
                                <Carousel fade>

                                    <Carousel.Item>
                                        <img className="d-block w-100" src="https://www.oldpoint.com/resourcefiles/main-images/home-insurance.jpg" alt="First slide" />

                                        <Carousel.Caption>
                                            <h3>Insurance </h3>

                                        </Carousel.Caption>
                                    </Carousel.Item>

                                    <Carousel.Item>
                                        <img className="d-block w-100" src="https://www.oldpoint.com/resourcefiles/main-images/home-insurance.jpg" alt="Second slide" />

                                        <Carousel.Caption>
                                            <h3>Insurance Benifits</h3>

                                        </Carousel.Caption>
                                    </Carousel.Item>

                                    <Carousel.Item>
                                        <img className="d-block w-100" src="https://www.oldpoint.com/resourcefiles/main-images/home-insurance.jpg" alt="Third slide" />

                                        <Carousel.Caption>
                                            <h3>Insurance Types</h3>

                                        </Carousel.Caption>
                                    </Carousel.Item>

                                </Carousel>
                            </Col>
                        </Card>

                    </Row>

                    <Row style={{ marginTop: "25px" }}>
                        <Col>
                            <Card>
                                <Card.Header as={"h5"}>Max Insure</Card.Header>
                                <Card.Body>
                                    <Card.Text>
                                        Article about Max Insure
                                    </Card.Text>
                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>

                    <Row style={{ marginTop: "25px" }}>
                        <Col>
                            <CardGroup>
                                <Card>
                                    <Card.Body>
                                        <Card.Title>Health Insurance</Card.Title>
                                        <Card.Text>
                                            Brief Insurance Details
                                        </Card.Text>
                                        <Link component={RouterLink} to={"/HealthInsurance"}>
                                            <Button variant="primary">Details</Button>
                                        </Link>

                                    </Card.Body>
                                </Card>

                                <Card>
                                    <Card.Body>
                                        <Card.Title>Home Insurance</Card.Title>
                                        <Card.Text>
                                            Brief Insurance Details.
                                        </Card.Text>
                                        <Link component={RouterLink} to={"/HomeInsurance"}>
                                            <Button variant="primary">Details</Button>
                                        </Link>
                                    </Card.Body>
                                </Card>

                                <Card>
                                    <Card.Body>
                                        <Card.Title>Car Insurance</Card.Title>
                                        <Card.Text>
                                            Brief Insurance Details.
                                        </Card.Text>
                                        <Button variant="primary">Details</Button>
                                    </Card.Body>
                                </Card>
                            </CardGroup>
                        </Col>
                    </Row>
                </Container>

            </div>
        </>
    )
}
export default Home;