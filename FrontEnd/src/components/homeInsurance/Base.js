import React, { useState } from 'react'

export default function Base() {

    const [currentPage, setCurrentPage] = useState(1)
    const [formData, setFormData] = useState({
        name: '',
        age: '',
        gender: '',
        email: '',
    });

    return (
        <div>
            {currentPage===1 &}
        </div>
    )
}
