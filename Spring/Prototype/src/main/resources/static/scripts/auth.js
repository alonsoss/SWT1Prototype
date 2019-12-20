// JavaScript Document
// Get data
db.collection('tasks').get().then(snapshot => {
	setupTasks(snapshot.docs)
});


// Signup
const signupForm = document.querySelector('#signup-form');
signupForm.addEventListener('submit', (e) => {
	e.preventDefault();
	
	// Get email field
	const email = signupForm['signup-email'].value;
	const password = signupForm['signup-password'].value;

	// Sign up user
	auth.createUserWithEmailAndPassword(email, password).then(cred => {
		const modal = document.querySelector('#modal-signup');
		M.Modal.getInstance(modal).close();
		signupForm.reset();
	});
});

const logout = document.querySelector('#logout')
logout.addEventListener("click", (e) => {
	e.preventDefault();
	auth.signOut().then(() => {
		console.log("Logged out")
	});
});