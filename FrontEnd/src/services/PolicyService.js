import axios from 'axios'

const API_URL = 'http://localhost:9090/maxinsure/policies';

// export const getDepts = async (token) => {
//     const axiosInstance = getAxiosInstanceWithToken(API_URL, token);
//     const result = await axiosInstance.get(`/department/viewall`);
//     return result.data;
// }

// export const addDept = async(dept)=>{
//     await axios.post(`${API_URL}/department/add`,dept); 
// }
// export const getDepts = async()=>{
//         const result = await axios.get(`${API_URL}/department/viewall`);
//         return result.data; 
// }
// export const getDeptById = async(id)=>{
//     const result =await axios.get(`${API_URL}/department/viewbyid/${id}`)
//     return result.data;
// }

export const getHomeInsurancePlans = async (planType, duration, cost) => {
    console.log(planType)
    const result = await axios.get(`${API_URL}/homeinsurance/ByType/${planType}/property-cost?cost=${cost}&duration=${duration}`)
    return result.data;
}
export const getHealthInsurancePlans = async (age, duration, cover, illness) => {

    const result = await axios.get(`${API_URL}/healthinsurance/checks?illness=${illness}&duration=${duration}
                                    &cover=${cover}&age=${age}`)

}