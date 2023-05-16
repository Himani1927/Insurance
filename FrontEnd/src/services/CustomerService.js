import axios from 'axios'

const API_URL = 'http://localhost:9091/maxinsure';

export const addHealthInsuranceCustomer = async (customer) => {
    const result = await axios.post(`${API_URL}/healthinsurance/user/add`,customer)
    return result.data
}

export const addHomeInsuranceCustomer = async (customer) => {
    const result = await axios.post(`${API_URL}/homeinsurance/user/add`,customer)
    return result.data
}