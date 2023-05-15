import React, { useState } from 'react'
import Navbar from '../../Bar/Navbar'
import { Card, Slider, Typography } from '@mui/material'
import BasicDetails from './BasicDetails'
import MedicalDetails from './MedicalDetails'
import SelectPlan from './SelectPlan'
import AddressDetails from './AddressDetails'

export default function HealthInsuranceBase() {

    const [insuranceData, setInsuranceData] = useState({
        'firstName': '',
        'lastName': '',
        'email': '',
        'contactNo': '',
        'age': '',
        'gender': '',
        'address': '',
        'city': '',
        'state': '',
        'pincode': '',
        'height': '',
        'weight': '',
        'hasPriorIllness': false,
        'priorIllnessName': '',
        'diagnosisYear': '',
        'policyDetails': {
            'planCode': '',
            'durationInYears': '1',
            'policyCover': '100000',
            'totalPremium': ''
        }
    })

    const [plans, setPlans] = useState([])
    const [progress, setProgress] = useState(0)

    const handleNext = () => {
        console.log(insuranceData)
        setProgress(progress + 1)
    }

    const handleBack = () => {
        setProgress(progress - 1)
    }




    return (
        <div className='homeBackground'>
            <Navbar />

            <Typography variant='h4' align='center' marginTop={'80px'} gutterBottom>Health Insurance</Typography>

            <Card variant='outlined' style={{ maxWidth: '950px', maxHeight: '50%', margin: '10px auto', padding: '10px 40px', }}>
                <Slider color='secondary' max={5} step={1} value={progress}  />

                {progress === 0 && (
                    <BasicDetails
                        insuranceData = {insuranceData}
                        setInsuranceData = {setInsuranceData}
                        handleNext = {handleNext}
                    />
                )}
                {progress === 1 && (
                    <MedicalDetails
                        insuranceData = {insuranceData}
                        setInsuranceData = {setInsuranceData}
                        handleNext = {handleNext}
                        handleBack = {handleBack}
                    />
                )}
                {progress === 2 && (
                    <SelectPlan
                        insuranceData = {insuranceData}
                        setInsuranceData = {setInsuranceData}
                        plans = {plans}
                        setPlans = {setPlans}
                        handleNext = {handleNext}
                        handleBack = {handleBack}
                    />
                )}
                {progress === 3 && (
                    <AddressDetails
                        insuranceData = {insuranceData}
                        setInsuranceData = {setInsuranceData}
                        plans = {plans}
                        setPlans = {setPlans}
                        handleNext = {handleNext}
                        handleBack = {handleBack}
                    />
                )}

            </Card>
            <div>
            </div>
        </div>

    )
}
