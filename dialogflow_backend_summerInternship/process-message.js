const Dialogflow = require("dialogflow");

// You can find your project ID in your Dialogflow agent settings
const projectId = process.env.DIALOGFLOW_PROJECT_ID;
const sessionId = "123478";
const languageCode = "en-US";
const config = {
  credentials: {
    private_key: process.env.DIALOGFLOW_PRIVATE_KEY,
    client_email: process.env.DIALOGFLOW_CLIENT_EMAIL,
  },
};
const sessionClient = new Dialogflow.SessionsClient(config);

const sessionPath = sessionClient.sessionPath(projectId, sessionId);
async function processMessage(message) {
  const request = {
    session: sessionPath,
    queryInput: {
      text: {
        text: message,
        languageCode,
      },
    },
  };

  const res = await sessionClient
    .detectIntent(request)
    .then((responses) => {
      return responses[0].queryResult.fulfillmentText;
    })
    .catch((err) => {
      console.error("ERROR:", err);
    });
  return res;
}

module.exports = processMessage;
