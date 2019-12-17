// JavaScript Document
const taskList = document.querySelector('.guides');

// Setup tasks

const setupTasks = (data) => {
	let html = '';
	data.forEach(doc => {
		const task = doc.data();
		const li = `
			<li>
        		<div class="collapsible-header grey lighten-4">${task.name}</div>
        		<div class="collapsible-body white">${task.description}</div>
			</li>
		`;
		html += li
	});
	taskList.innerHTML = html;
}


// setup materialize components
document.addEventListener('DOMContentLoaded', function () {

	var modals = document.querySelectorAll('.modal');
	M.Modal.init(modals);
	
	var items = document.querySelectorAll('.collapsible');
	M.Collapsible.init(items);

});
