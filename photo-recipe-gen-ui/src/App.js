import './App.css';
import React, { useState } from 'react';
import ImageGenerator from './components/ImageGenerator';
import ChatComponent from './components/ChatComponent';
import RecipeGenerator from './components/RecipeGenerator';

function App() {
  const [activeTab, setActiveTab] = useState('image-generator');

  const handleTabChage = (tab) => {
    console.log(tab);
    setActiveTab(tab);
  }

  return (
    <div className="App">
      <button className={activeTab === 'image-generator' ? 'active' : ''}
        onClick={() => handleTabChage('image-generator')}>Image Generator</button>
      <button className={activeTab === 'chat' ? 'active' : ''}
      onClick={() => handleTabChage('chat')}>Ask AI</button>
      <button className={activeTab === 'recipe-generator' ? 'active' : ''}
      onClick={() => handleTabChage('recipe-generator')}>Recipe Generator</button>
      <div>
        {activeTab === 'image-generator' && <ImageGenerator />}
        {activeTab === 'chat' && <ChatComponent />}
        {activeTab === 'recipe-generator' && <RecipeGenerator />}
      </div>
    </div>
  );
}

export default App;
