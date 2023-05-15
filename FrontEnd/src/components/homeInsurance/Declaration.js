import { Button, Grid, Typography } from '@mui/material'
import React from 'react'

export default function Declaration({
    handleNext, handleBack
}) {
    return (
        <div>
            <Typography gutterBottom variant='h5'> Declaration </Typography>
            <Grid item xs={12} sm={6}>
                <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
            </Grid>
            <Grid item xs={12} sm={6}>
                <Button variant='contained' type='submit' color='secondary' fullWidth onClick={handleNext} >Next</Button>
            </Grid>
        </div>
    )
}
