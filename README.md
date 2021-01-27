# GraphQL-Sample

TEST 서버: https://rickandmortyapi.com/graphql/

### Install Apollo
```
brew install apollo-cli
```

### Download schema.json
```
apollo schema:download --endpoint=서버주소 schema.json
```

### Create ~.graphql
예시)
```graphql
query FeedResult {
  characters {
    results {
      name
      species
      gender
      image
    }
  }
}
```

### Request
Callback
```kotlin
apolloClient.query(TestQuery())
    .enqueue(object : ApolloCall.Callback<TestQuery.Data>() {
        override fun onResponse(response: Response<TestQuery.Data>) {
            ...
        }

        override fun onFailure(e: ApolloException) {
            ...
        }
    })
```
Rx
```kotlin
apolloClient.rxQuery(TestQuery())
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(...)
```
