# GraphQL-Sample

Android에서 GraphQL을 활용한 샘플 코드입니다.

TEST 서버: https://rickandmortyapi.com/graphql/

### Apollo Install
```
brew install apollo-cli
```

### schema.json Download
```
apollo schema:download --endpoint=https://rickandmortyapi.com/graphql schema.json
```

### Request
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
