import { Button, Grid, MenuItem, Select, TextField, Typography } from '@mui/material'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { addHealthInsuranceCustomer, addHomeInsuranceCustomer } from '../../services/CustomerService';
import { addPayment } from '../../services/PaymentService';

export default function Payment({
    insuranceData, type
}) {

    const navigate = useNavigate();

    const [payment, setPayment] = useState({
        'policyCode': '',
        'paymentAmount': insuranceData.policyDetails.totalPremium,
        'paymentMode': '',
    })

    const [mode, setMode] = useState('')

    const handleChange = (e) => {
        setPayment({ ...payment, [e.target.name]: e.target.value })
        if (e.target.name === 'paymentMode') setMode(e.target.value)
    }
    const [month, setMonth] = useState('')
    const [year, setYear] = useState('')
    const [bank, setBank] = useState('')

    const handleNavigation = () => {
        navigate('/');
    }

    if (type === 'health') console.log(type)

    const handlePay = async () => {

        if (type === 'health') {
            const data = await addHealthInsuranceCustomer(insuranceData)

            setPayment((prevPayment) => ({
                ...prevPayment,
                policyCode: data.policyDetails.policyCode,
            }))
            await addPayment(payment)

        } else if (type === 'home') {
            const data = await addHomeInsuranceCustomer(insuranceData)
            
            
            setPayment((prevPayment) => ({
                ...prevPayment,
                policyCode: data.policyDetails.policyCode,
            }))
            await addPayment(payment)
        }
        navigate('/');
    }

    return (
        <div style={{ maxWidth: '750px', margin: '10px auto' }}>
            <Typography align='center' variant='h5' gutterBottom>Payment Process</Typography>
            <form>
                <Grid container spacing={1.5} style={{ padding: '5px' }} >
                    <Grid item xs={12}>
                        <Typography sx={{ display: 'inline' }}> Payment Method  </Typography>
                        <Select value={payment.paymentMode} onChange={handleChange}
                            name='paymentMode' size='small'
                            displayEmpty>
                            <MenuItem value="" disabled>Select</MenuItem>
                            <MenuItem value={'Debit Card'} >Debit Card</MenuItem>
                            <MenuItem value={'NetBanking'} >Net-Banking</MenuItem>
                        </Select>
                    </Grid>

                    {mode === 'Debit Card' && (

                        <Grid container margin={'15px 10px'} spacing={2}>
                            <Grid item xs={6} >
                                <TextField label="Card number" color='secondary' fullWidth type='number'
                                    variant='outlined' placeholder='12 digit Card number' required />
                            </Grid>
                            <Grid item xs={6}>
                                <TextField label="Cvv" color='secondary' fullWidth type='number'
                                    variant='outlined' placeholder='3 digit cvv' required />
                            </Grid>
                            <Grid item xs={2}>
                                <Typography sx={{ display: 'inline' }}> Valid Until </Typography>
                            </Grid>
                            <Grid item xs={3}>
                                <Select value={month}
                                    onChange={(e) => setMonth(e.target.value)}
                                    name="month" size="small" displayEmpty required>
                                    <MenuItem value="" disabled>Month</MenuItem>
                                    <MenuItem value={'January'}>January</MenuItem>
                                    <MenuItem value={'February'}>February</MenuItem>
                                    <MenuItem value={'March'}>March</MenuItem>
                                    <MenuItem value={'April'}>April</MenuItem>
                                    <MenuItem value={'May'}>May</MenuItem>
                                    <MenuItem value={'June'}>June</MenuItem>
                                    <MenuItem value={'July'}>July</MenuItem>
                                    <MenuItem value={'August'}>August</MenuItem>
                                    <MenuItem value={'September'}>September</MenuItem>
                                    <MenuItem value={'October'}>October</MenuItem>
                                    <MenuItem value={'November'}>November</MenuItem>
                                    <MenuItem value={'December'}>December</MenuItem>
                                </Select>
                            </Grid>
                            <Grid item xs={3}>
                                <Select value={year}
                                    onChange={(e) => setYear(e.target.value)}
                                    name='year' size='small' displayEmpty required>
                                    <MenuItem value="" disabled>Year</MenuItem>
                                    <MenuItem value={'2023'} >2023</MenuItem>
                                    <MenuItem value={'2024'} >2024</MenuItem>
                                    <MenuItem value={'2025'} >2025</MenuItem>
                                    <MenuItem value={'2026'} >2026</MenuItem>
                                    <MenuItem value={'2027'} >2027</MenuItem>
                                    <MenuItem value={'2028'} >2028</MenuItem>
                                </Select>
                            </Grid>
                            <Grid item xs={7}>
                                <TextField label="Name" color='secondary' fullWidth
                                    variant='outlined' placeholder="Card Holder's Name" required />
                            </Grid>
                            <Grid item xs={4} marginLeft={'16%'} marginTop={'25px'}>
                                <Button variant='contained' color='secondary'
                                    fullWidth onClick={handleNavigation}>
                                    Cancel
                                </Button>
                            </Grid>
                            <Grid item xs={4} marginTop={'25px'}>
                                <Button variant='contained' color='success' fullWidth onClick={handlePay}>
                                    Pay
                                </Button>
                            </Grid>
                        </Grid>
                    )}
                    {mode === 'NetBanking' && (
                        <Grid container margin={'15px 10px'} spacing={2}>
                            <Grid item xs={2} marginTop={'4px'}>
                                <Typography sx={{ display: 'inline' }} > Bank </Typography>
                            </Grid>
                            <Grid item xs={5}>
                                <Select value={bank}
                                    onChange={(e) => setBank(e.target.value)}
                                    name='bank' size='small' displayEmpty required>
                                    <MenuItem value="" disabled>Select Bank</MenuItem>
                                    <MenuItem value={'Axis Bank'} >Axis Bank</MenuItem>
                                    <MenuItem value={'State Bank of India'}>State Bank of India</MenuItem>
                                    <MenuItem value={'HDFC Bank'}>HDFC Bank</MenuItem>
                                    <MenuItem value={'ICICI Bank'}>ICICI Bank</MenuItem>
                                    <MenuItem value={'Punjab National Bank'}>Punjab National Bank</MenuItem>
                                    <MenuItem value={'Bank of Baroda'}>Bank of Baroda</MenuItem>
                                    <MenuItem value={'Canara Bank'}>Canara Bank</MenuItem>
                                    <MenuItem value={'Bank of India'}>Bank of India</MenuItem>
                                    <MenuItem value={'IndusInd Bank'}>IndusInd Bank</MenuItem>
                                </Select>
                            </Grid>
                            <Grid item xs={6}>
                                <TextField label="Username" color='secondary' fullWidth
                                    variant='outlined' placeholder="Net-Banking Username" required />
                            </Grid>
                            <Grid item xs={6}>
                                <TextField label="Password" color='secondary' fullWidth type='password'
                                    variant='outlined' placeholder="Net-Banking Password" required />
                            </Grid>
                            <Grid item xs={4} marginLeft={'15%'} marginTop={'25px'}>
                                <Button variant='contained' color='secondary'
                                    fullWidth onClick={handleNavigation}>
                                    Cancel
                                </Button>
                            </Grid>
                            <Grid item xs={4} marginTop={'25px'}>
                                <Button variant='contained' color='success' fullWidth onClick={handlePay}>
                                    Pay
                                </Button>
                            </Grid>
                        </Grid>
                    )}
                </Grid>
            </form>
        </div>
    )
}
