/** Fetches tasks from the server and adds them to the DOM. */
function loadMessages() {
    fetch('/show-message').then(response => response.json()).then((UserMessages) => {
      const messageListElement = document.getElementById('message-list');
      UserMessages.forEach((userMessage) => {
        messageListElement.appendChild(createTaskElement(userMessage));
      })
    });
  }
  function createTaskElement(userMessage) {
    const messageEl = document.createElement('li');
    
    const text = document.createElement('span');
    text.innerText = userMessage.text;
    
  
  
  messageEl.appendChild(text);
    return messageEl;
  }