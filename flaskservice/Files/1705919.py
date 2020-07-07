# TODO: A utility class which will be created by the user , with Class name as " _[your roll number]" ,
# TODO: all transformations should be written inside a function which will be called inside the predict method
import pandas as pd


class _1705919():

    # TODO: Please note that document id should be present till the getPredictions method
    def __tranformation(self, data):
        print(data.columns)

        data['document_create_date_norm'] = pd.to_datetime(
            data.document_create_date_norm)
        data['doc_create_day'] = data.document_create_date_norm.map(
            lambda x: x.day)
        data['doc_create_month'] = data.document_create_date_norm.map(
            lambda x: x.month)
        data['doc_create_year'] = data.document_create_date_norm.map(
            lambda x: x.year)
        data.drop('document_create_date_norm', axis=1, inplace=True)

        # mapper_month = data.groupby('doc_create_month')[
        #     'actual_payment_amount'].mean().to_dict()
        # data['doc_create_month_encoded'] = data.doc_create_month.map(
        #     mapper_month)

        # mapper_year = data.groupby('doc_create_year')[
        #     'actual_payment_amount'].mean().to_dict()
        # data['doc_create_year_encoded'] = data.doc_create_year.map(mapper_year)

        # mapper_day = data.groupby('doc_create_day')[
        #     'actual_payment_amount'].mean().to_dict()
        # data['doc_create_day_encoded'] = data.doc_create_day.map(mapper_day)

        # mapper_pt = data.groupby('cust_payment_terms')[
        #     'actual_payment_amount'].mean().to_dict()
        # data['cust_payment_terms_encoded'] = data.cust_payment_terms.map(
        #     mapper_pt)

        return data

    def getPredictions(self, data, model):
        data = self.__tranformation(data)

        # your feature list, column names
        features = ['customer_number_norm', 'days_past_due_date', 'doc_create_month',
                    'doc_create_year', 'doc_create_day',
                    'cust_payment_terms']
        print(data[features])
        # data should be a dataFrame and not a numpy array
        predictions = model.predict(data[features])
        data['predictions'] = predictions
        pred = data.loc[:, ['document_number_norm',
                            'predictions']].to_dict(orient="records")
        print("PRED", pred)
        return pred
