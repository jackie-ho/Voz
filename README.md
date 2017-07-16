# Voz

Voice control using a Java based AWS Lambda function and Lex support.

## Use ##
The user logs in and authenticates AWS access using a cognito account assuming the aws role and can have conversations with Lex in order to perform actions.
The business logic is carried out by an aws lambda server which can make calls to the db and return JSON objects which the android app can then add to a UI.

## Lex Processing ##
The Lex/Lambda processing offers two benefits. One is to move the processing power and responsibilites away from the android app, and act as a black box of post/request calls.
The second is to handle all of the voice recording, analysis, transcription, and decision making depending on the words spoken. 


