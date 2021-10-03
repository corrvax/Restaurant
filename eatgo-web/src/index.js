(async()=>{
    const url = 'http://localhost:8080/rstaurants';
    const response = await fetch(url);
    const data = await response.json();

    const element = document.getElementById('app');
    element.innerHTML =`
        ${restaurants.map(restaurant =>`
            <p>
              ${restaurants[0].id}
              ${restaurants[0].name}
              ${restaurants[0].address}
            </p>
        `).join('')}
    `;

 })();