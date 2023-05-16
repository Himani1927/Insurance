import { Slider, Typography } from '@mui/material'
import React, { useState } from 'react'
import BasicDetails from './BasicDetails';
import { Card } from 'react-bootstrap';
import PropertyType from './PropertyType';
import SelectPlan from './SelectPlan';
import Navbar from '../../Bar/Navbar';

import '../../App.css'
import AddressDetails from './AddressDetails';
import Declaration from './Declaration';
import Payment from '../healthInsurance/Payment';


export default function HomeInsuranceBase() {

    const [insuranceData, setInsuranceData] = useState({
        'firstName': '',
        'lastName': '',
        'email': '',
        'contactNo': '',
        'propertyType': '',
        'residentType': '',
        'insureBuilding': false,
        'buildingValue': '',
        'insureHouseholdItems': false,
        'itemsValue': '',
        'propertyAddress': '',
        'propertyCity': '',
        'propertyState': '',
        'propertyPincode': '',
        'isPresentAddress': false,
        'communicationAddress': '',
        'communicationCity': '',
        'communicationPincode': '',
        'communicationState': '',
        'policyDetails': {
            'planCode': '',
            'durationInYears': '1',
            'policyCover': '',
            'totalPremium': ''
        }
    });

    const [plans, setPlans] = useState([]);

    const [progress, setProgress] = useState(0)

    const handleNext = () => {
        console.log(insuranceData)
        setProgress(progress + 1)
    }

    const handleBack = () => {
        setProgress(progress - 1)
    }

    const mark = [
        {
            value: 0,
            label: "Basic Details"
        },
        {
            value: 1,
            label: "Property Details"
        },
        {
            value: 2,
            label: "Select Plan"
        },
        {
            value: 3,
            label: "Address"
        },
        {
            value: 4,
            label: "Declaration"
        },
        {
            value: 5,
            label: "Payment"
        },

    ]

    return (
        <div className='homeBackground'>
            <Navbar />

            <Typography variant='h4' align='center' marginTop={'80px'} gutterBottom>Home Insurance</Typography>

            <Card variant='outlined' style={{ maxWidth: '950px', maxHeight: '50%', margin: '10px auto', padding: '10px 40px', }}>
                <Slider color='secondary' max={5} step={1} value={progress} marks={mark} />

                {progress === 0 && (
                    <BasicDetails
                        insuranceData={insuranceData}
                        setInsuranceData={setInsuranceData}
                        handleNext={handleNext}
                    />
                )}
                {progress === 1 && (
                    <PropertyType
                        insuranceData={insuranceData}
                        setInsuranceData={setInsuranceData}
                        handleNext={handleNext}
                        handleBack={handleBack}
                    />
                )}
                {progress === 2 && (
                    <SelectPlan
                        insuranceData={insuranceData}
                        setInsuranceData={setInsuranceData}
                        handleNext={handleNext}
                        handleBack={handleBack}
                        plans={plans}
                        setPlans={setPlans}
                    />
                )}
                {progress === 3 && (
                    <AddressDetails
                        insuranceData={insuranceData}
                        setInsuranceData={setInsuranceData}
                        handleNext={handleNext}
                        handleBack={handleBack}
                    />
                )}
                {progress === 4 && (
                    <Declaration
                        handleNext={handleNext}
                        setProgress={setProgress}
                    />
                )}
                {progress === 5 && (
                    <Payment
                        insuranceData={insuranceData}
                        type = {'home'}
                    />
                )}
            </Card>
            <div>
            </div>
        </div>
    );
}
