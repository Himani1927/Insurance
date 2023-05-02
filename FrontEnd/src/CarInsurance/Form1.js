import { Form, Row } from "react-bootstrap";

function Form1(){

    return(
        <>
          <Form>
            <Row>
                <Col>
                <Form.Control placeholder="First name" /> 
                </Col>
                <Col>
                <Form.Control placeholder="Last name" /> 
                </Col>
            </Row>
          </Form>
        </>
    )
}
export default Form1;