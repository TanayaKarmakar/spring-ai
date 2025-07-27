import React, {useState} from "react";

function ChatComponent() {
    const [prompt, setPrompt] = useState('');
    const [response, setResponse] = useState('');

    const askAI = async () => {
        try {
            const res = await fetch(`http://localhost:8080/api/askAI?prompt=${prompt}`);

            if (!res.ok) {
                throw new Error('Failed to get response from AI');
            }

            const data = await res.text();
            console.log(data);
            setResponse(data || 'No response received');
        } catch (error) {
            console.error('Error asking AI:', error);
            alert('Failed to get response from AI. Please try again.');
        }
    };

    return (
        <div>
            <h2>Talk to AI....</h2>
            <input type="text" 
            placeholder="Enter a prompt for AI" 
            value = {prompt}
            onChange={(e) => setPrompt(e.target.value)}/>
        
            <button onClick={() => askAI()}>Ask AI</button>
            <div className="output">
                <p>{response}</p>
            </div>
        </div>
    );
}

export default ChatComponent;