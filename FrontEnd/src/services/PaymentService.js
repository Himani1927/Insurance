import axios from 'axios'

const API_URL = 'http://localhost:9092/maxinsure/payment';

export const addPayment = async(payment) => {
    console.log(payment)
    await axios.post(`${API_URL}`,payment)
}