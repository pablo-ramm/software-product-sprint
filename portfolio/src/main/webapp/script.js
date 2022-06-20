// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact about me to the page.
 */
function addRandomGreeting() {
  const facts =
      ['My favorite food is seafood', 'I like soccer but I am not good at it', 'My favorite programming language is c++', 'The first programming language I learnt was java'];

  // Pick a random fact about me.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

async function lastTime(){
    const response = await fetch("/lastTime");
    const textResponse = await response.text();

    const pLastTime = document.getElementById("lastTime");
    pLastTime.innerText = textResponse;
}

async function quote(){
    const jsonRes = await fetch("/quotes");
    const object = await jsonRes.json();

    var random_number = Math.floor(Math.random() * 3);
    const quoteParag = document.getElementById("quote");
    quoteParag.innerText = object.messages[random_number];
}
