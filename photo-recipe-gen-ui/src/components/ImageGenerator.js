import React, {useState} from "react";

function ImageGenerator() {
    const [prpmpt, setPrompt] = useState('');
    const [imageUrls, setImageUrls] = useState([]);

    const generateImageHandler = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/generateImage?prompt=${prpmpt}`);

            if (!response.ok) {
                throw new Error('Failed to generate image');
            }

            const data = await response.json();
            console.log(data);
            setImageUrls([data] || []);
        } catch (error) {
            console.error('Error generating image:', error);
            alert('Failed to generate image. Please try again.');
        }
    }

    return (
        <div className="tab-content">
            <h2>Generate Image</h2>
            <input
                type="text"
                value={prpmpt}
                onChange={(e) => setPrompt(e.target.value)}
                placeholder="Enter your prompt here"
            />
            <button onClick = {generateImageHandler}>Generate Image</button>
            <div className="image-grid">
                {imageUrls.map((url, index) => (
                    <img key={index} src={url} alt={`Generated ${index}`} />
                ))}
                {[...Array(4 - imageUrls.length)].map((_, index) => 
                    <div key={index + imageUrls.length} className="empty-image-slot"></div>
                )}   
            </div>
        </div>
    );
}

export default ImageGenerator;