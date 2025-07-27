import React, {useState} from "react";

function RecipeGenerator() {
    const [ingredients, setIngredients] = useState('');
    const [cuisine, setCuisine] = useState('');
    const [recipe, setRecipe] = useState('any');   
    const [dietaryRestrictions, setDietaryRestrictions] = useState('');

    const createRecipeHandler = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/recipe?ingredients=${ingredients}&cuisine=${cuisine}&dietaryRestrictions=${dietaryRestrictions}`);        
            if (!response.ok) {
                throw new Error('Failed to create recipe');
            }   
            const data = await response.text();
            console.log(data);
            setRecipe(data || 'No recipe found');
        } catch (error) {
            console.error('Error creating recipe:', error);
            alert('Failed to create recipe. Please try again.');
        }
    }

    return (
        <div>
            <h2>Create a Recipe ....</h2>
            <input
                type="text"
                value={ingredients}
                onChange={(e) => setIngredients(e.target.value)}
                placeholder="Enter ingredients (comma separated)"
            />

            <input
                type="text"
                value={cuisine}
                onChange={(e) => setCuisine(e.target.value)}
                placeholder="Enter cuisine type"
            />

            <input
                type="text"
                value={dietaryRestrictions}
                onChange={(e) => setDietaryRestrictions(e.target.value)}
                placeholder="Enter dietary restrictions (comma separated)"
            />

            <button onClick={() => createRecipeHandler()}>Create Recipe</button>
            <div className="output">
                <p>{recipe}</p>    
            </div>
        </div>
    );
}

export default RecipeGenerator;