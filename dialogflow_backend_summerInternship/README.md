# Chatbot Backend

## Setting up Dialogflow

- Head over to the Dialogflow website and sign up for a free account.

- Click on the Create Agent button. Give your agent a name (image below shows agent with name "weather-bot") and fill in the remaining fields, then hit the CREATE button. You will be redirected to the main page of the agent. [Image Below]

![Agent_Dialogflow](https://images.ctfassets.net/1es3ne0caaid/44icEurvheqIA4O88ACy84/8de22c011fe9f4aa6a22c2942209d8b8/weather-bot-dialogflow-1.png)

- Open the file `variables.env` with your favourite text editor.

- Go to Dialogflow and to your agent’s settings. Copy `Project ID` and paste it in `varibales.env` along `DIALOGFLOW_PROJECT_ID`. At this point, your `variables.env` file would look something like below :

```
//variables.env

DIALOGFLOW_PRIVATE_KEY="-----BEGIN PRIVATE KEY-----\n<__KEY__>\n-----END PRIVATE KEY-----\n"
DIALOGFLOW_CLIENT_EMAIL=foobar@<PROJECT_ID>.iam.gserviceaccount.com
DIALOGFLOW_PROJECT_ID="EXAMPLE-123"
```

- Back in settings, under Google Project, click on the service account name. This will open your Google Cloud Platform service account’s page. [Image Below]

![Service_Account](https://images.ctfassets.net/1es3ne0caaid/2WQPzCkVheycGEu0kSUSEW/b79a70670572b6b6836abb957d7d3112/weather-bot-dialogflow-2.png)

- You should see a Dialogflow Integration service account in the list of accounts. Click on the three dots menu on the right and select Create Key. Leave the file format as JSON and click Create. This will download a JSON file to your computer.

![Dialogflow_Key](https://images.ctfassets.net/1es3ne0caaid/3nahw1PFnywEuik6qquaeC/d38a9e6c95495c615a9a34e6a5a52a37/weather-bot-dialogflow-3.png)

- Open the JSON file with your favorite text editor. You only need two of the values: `private_key` and `client_email`.

- Open the file `variables.env`.

  - Paste the value of `private_key` along `DIALOGFLOW_PRIVATE_KEY` .
  - Paste the value of `client_email` along `DIALOGFLOW_CLIENT_EMAIL` .
  - Maintain `""` as in examples.

- Your `variables.env` file should look something like below :

```
//variables.env

DIALOGFLOW_PRIVATE_KEY="-----BEGIN PRIVATE KEY-----\nexample12345\n-----END PRIVATE KEY-----\n"
DIALOGFLOW_CLIENT_EMAIL=example@<EXAMPLE-123>.iam.gserviceaccount.com
DIALOGFLOW_PROJECT_ID="EXAMPLE_!23"
```

- Save the file

## Enable `Small Talk`

Dialogflow provides a neat feature that allows any bot to have simple conversations with users without writing any code. To enable this feature, click Small Talk on the sidebar and toggle it on.

![Small_Talk](https://images.ctfassets.net/1es3ne0caaid/3Q0IEmbBywKAsyo4gKesQE/fe47eb7cdc7ecc5448c129fdb7607d23/weather-bot-dialogflow-4.png)

## Setting Up the Server

Run the below code to install dependencies :

```
npm i
```

After the above has completed execution, run

```
npm start
```

This will start the server on `PORT 4000` .
