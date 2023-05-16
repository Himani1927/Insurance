import { Button, Checkbox, Grid, Typography } from '@mui/material'
import React, { useState } from 'react'

export default function Declaration({
    handleNext, setProgress
}) {

    const [declare, setDeclare] = useState(false);

    const handleCheckbox = () => {
        if (declare) setDeclare(false)
        else setDeclare(true)
    }

    const handleEdit = () => {
        setProgress(0)
    }

    return (
        <div>
            <Typography gutterBottom variant='h5' align='center'> Declaration </Typography>
            <Grid container spacing={1.5}margin={'5px'}>
                <Grid item xs={1}>
                    <Checkbox  color='success' size='large' checked={declare}
                        name='hasPriorIllness' onChange={handleCheckbox}
                    ></Checkbox>
                    
                </Grid>
                <Grid item xs={11}>
                <Typography  gutterBottom>
                        I confirm that all the details provided in this application are accurate
                        to the best of my knowledge, and I understand that any false information
                        may result in the cancellation of my insurance policy.
                    </Typography>
                </Grid>
                <Grid item xs={6}>
                    <Button variant='contained' color='secondary'
                        fullWidth onClick={handleEdit}>Edit</Button>
                </Grid>
                <Grid item xs={6}>
                    <Button variant='contained' type='submit' color='secondary'
                        fullWidth disabled={!declare} onClick={handleNext} >Next</Button>
                </Grid>
            </Grid>

        </div>
    )
}
