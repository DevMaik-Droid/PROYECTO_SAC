/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode:'class',
  darkMode: 'media',
  content: [    
    "./src/**/*.{html,ts}", // add this line],
    "./node_modules/flowbite/**/*.js" // add this line
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('flowbite/plugin') // add this line
  ],
}

