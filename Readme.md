# JSON

## Content

[Use cases](#use-cases)

[File extention](#file-extention)

[Plugins](#plugins)

[Whitespace and rules](#whitespace-and-rules)

[Data structures](#data-structures)

[Schema](#schema)

[JavaScript](#javascript)

[Python](#python)

[Java](#java)

[Java Examples](#java-examples)

[JSON APIs](#json-apis)

[JSON as a File Format](#json-as-a-file-format)

[JSON problems](#json-problems)

[Utils](#utils)


## Use cases

JSON (JavaScript Object Notation) is an open standard file format and data interchange format that uses human-readable text 
to store and transmit data objects consisting of attribute–value pairs and arrays (or other serializable values). 

It is a commonly used data format with diverse uses in electronic data interchange, including that of web applications 
with servers.

JSON is a language-independent data format. It was derived from JavaScript, but many modern programming languages 
include code to generate and parse JSON-format data. 

- configuration files

- Web APIs

- Data Exchange between Applications

- Data Storage(PostgreSQL,MySQL,Oracle Database,SQL Server,SQLite,
MongoDB,Couchbase,Cassandra,CouchDB,RethinkDB,
Google Cloud Spanner,Azure Cosmos DB,CockroachDB,TiDB)



## File extention

JSON filenames use the extension `.json`. The official MIME type for JSON text is application/json

## Plugins

- Beautify

- json

- converters

[Content](#content)


## Whitespace and rules

Whitespace is allowed and ignored around or between syntactic elements (values and punctuation,
but not within a string value). Four specific characters are considered whitespace for this purpose:
space, horizontal tab, line feed, and carriage return. In particular, the byte order mark must not 
be generated by a conforming implementation (though it may be accepted when parsing JSON). 
JSON does not provide syntax for comments.


A couple of important rules to note:

In the JSON data format, the keys must be enclosed in double quotes.
The key and value must be separated by a colon (:) symbol.
There can be multiple key-value pairs. Two key-value pairs must be separated by a comma (,) symbol.
No comments (// or /* */) are allowed in JSON data. (But you can get around that, if you're curious.)

[Content](#content)

## Data structures


### String

```json
{
  "name": "John Doe"
}


```


### Number

```json
{
  "age": 30,
  "salary": 55000.50
}

```




### Boolean

```json
{
  "isEmployed": true,
  "isMarried": false
}

```




### Object

```json
{
  "person": {
    "name": "Alice",
    "age": 25
  }
}
```




### Array

```json
{
  "fruits": ["apple", "banana", "cherry"]
}
```




### Null

```json
{
  "address": null
}
```


[Content](#content)

## Schema

JSON Schema is a vocabulary that you can use to annotate and validate JSON documents.

After you create the JSON Schema document, you can validate the example data against 
your schema using a validator in a language of your choice.

https://json-schema.org/implementations

https://json-schema.org/learn/getting-started-step-by-step

### create a basic schema definition

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "https://example.com/product.schema.json",
  "title": "Product",
  "description": "A product from Acme's catalog",
  "type": "object",
  "properties": {
    "productId": {
      "description": "The unique identifier for a product",
      "type": "integer"
    },
    "productName": {
      "description": "Name of the product",
      "type": "string"
    },
    "price": {
      "description": "The price of the product",
      "type": "number",
      "exclusiveMinimum": 0
    },
    "tags": {
      "description": "Tags for the product",
      "type": "array",
      "items": {
        "type": "string"
      },
      "minItems": 1,
      "uniqueItems": true
    },
    "dimensions": {
      "type": "object",
      "properties": {
        "length": {
          "type": "number"
        },
        "width": {
          "type": "number"
        },
        "height": {
          "type": "number"
        }
      },
      "required": [ "length", "width", "height" ]
    },
    "warehouseLocation": {
      "description": "Coordinates of the warehouse where the product is located.",
      "$ref": "https://example.com/geographical-location.schema.json"
    }
  },
  "required": [ "productId", "productName", "price" ]
}


```

### Validate

```json
{
  "productId": 1,
  "productName": "An ice sculpture",
  "price": 12.50,
  "tags": [ "cold", "ice" ],
  "dimensions": {
    "length": 7.0,
    "width": 12.0,
    "height": 9.5
  },
  "warehouseLocation": {
    "latitude": -78.75,
    "longitude": 20.4
  }
}


```

[Content](#content)

## JavaScript

### JSON Data to a JavaScript Object

A common use of JSON is to exchange data to/from a web server.

When receiving data from a web server, the data is always a string.

Parse the data with JSON.parse(), and the data becomes a JavaScript object.

```js
const obj = JSON.parse('{"name":"John", "age":30, "city":"New York"}');


const text = '["Ford", "BMW", "Audi", "Fiat"]';
const myArr = JSON.parse(text);
```

### JavaScript Object to JSON Data

A common use of JSON is to exchange data to/from a web server.

When sending data to a web server, the data has to be a string.

Convert a JavaScript object into a string with JSON.stringify().

```js
const obj = {name: "John", age: 30, city: "New York"};
const myJSON = JSON.stringify(obj);


const arr = ["John", "Peter", "Sally", "Jane"];
const myJSON = JSON.stringify(arr);

```

Store to and retrive from  local storage

```js
// Storing data:
const myObj = {name: "John", age: 31, city: "New York"};
const myJSON = JSON.stringify(myObj);
localStorage.setItem("testJSON", myJSON);

// Retrieving data:
let text = localStorage.getItem("testJSON");
let obj = JSON.parse(text);
document.getElementById("demo").innerHTML = obj.name;
```


It is a common mistake to call a JSON object literal "a JSON object".

JSON cannot be an object. JSON is a string format.

The data is only JSON when it is in a string format. When it is converted to a JavaScript variable, it becomes a JavaScript object.

```js
const myJSON = '{"name":"John", "age":30, "car":null}';
const myObj = JSON.parse(myJSON);
x = myObj.name;


const myJSON = '{"name":"John", "age":30, "car":null}';
const myObj = JSON.parse(myJSON);
x = myObj["name"];



const myJSON = '{"name":"John", "age":30, "car":null}';
const myObj = JSON.parse(myJSON);

let text = "";
for (const x in myObj) {
  text += x + ", ";
}

```


[Content](#content)


## Python



| Data Type in JSON | Data Type in Python | Description | Example (JSON) | Example (Python) |
|---|---|---|---|---|
| string | str | An ordered sequence of characters | "name" | 'name' |
| number (integer) | int | An integer number | 42 | 42 |
| number (float) | float | A floating-point number | 3.14159 | 3.14159 |
| boolean | bool | A Boolean value (True or False) | true | True |
| boolean | bool | A Boolean value (True or False) | false | False |
| null | None | Represents the absence of a value | null | None |
| object | dict | An unordered collection of key-value pairs | {"name": "Alice", "age": 30} | {'name': 'Alice', 'age': 30} |
| array | list | An ordered collection of items | [1, "apple", 3.14] | [1, "apple", 3.14] |
| array | tuple | An immutable ordered collection of items | (1, "apple", 3.14) | (1, "apple", 3.14) |


### Read

```json
data = {
    "president": {
        "name": "John Wick",
        "species": "Betelgeusian"
    }
}
```


```python
import json


with open("data_file.json", "r") as read_file:
    data = json.load(read_file)


```

### Write


```python
import json


data = {
    "president": {
        "name": "Zaphod Beeblebrox",
        "species": "Betelgeusian"
    }
}

with open("data_file.json", "w") as write_file:
    json.dump(data, write_file)

```


```json
data = {
    "president": {
        "name": "John Wick",
        "species": "Betelgeusian"
    }
}
```
[Content](#content)


## Java


| Data Type in JSON | Data Type in Java | Description | Example (JSON) | Example (Java) |
|---|---|---|---|---|
| string | `java.lang.String` | An ordered sequence of characters | "name" | "name" |
| number (integer or float) | `java.lang.Number` | A numeric value | 42 | 42 |  |
| boolean | `java.lang.Boolean` | A Boolean value (true or false) | true | true |
| null | `null` | Represents the absence of a value | null | null |
| array | `java.util.List` | An ordered collection of items | [1, "apple", 3.14] | `List<Object> myList = Arrays.asList(1, "apple", 3.14);` |
| object | `java.util.Map` | An unordered collection of key-value pairs | {"name": "Alice", "age": 30} | `Map<String, Object> myMap = new HashMap<>();<br> myMap.put("name", "Alice");<br> myMap.put("age", 30);` |


The most popular are:

Jackson
Gson
json-io
Genson


### Jackson

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>${jackson.version}</version>
</dependency>

```

```java 

String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"weight\":4}";
```

Escaping double quotes within a string: "This is a string with \"double quotes\" inside." 
(one backslash before each double quote to indicate it's part of the string, not the delimiter).



```java

@Test
public void whenSerializeAndDeserializeUsingJackson_thenCorrect() 
  throws IOException{
    Foo foo = new Foo(1,"first");
    ObjectMapper mapper = new ObjectMapper();

    String jsonStr = mapper.writeValueAsString(foo);
    Foo result = mapper.readValue(jsonStr, Foo.class);
    assertEquals(foo.getId(),result.getId());
}
```
### Gson


```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>${gson.version}</version>
</dependency>
```


```java
@Test
public void whenSerializeAndDeserializeUsingGson_thenCorrect(){
    Gson gson = new Gson();
    Foo foo = new Foo(1,"first");

    String jsonStr = gson.toJson(foo);
    Foo result = gson.fromJson(jsonStr, Foo.class);
    assertEquals(foo.getId(),result.getId());
}

```


### json-io


```xml
<dependency>
    <groupId>com.cedarsoftware</groupId>
    <artifactId>json-io</artifactId>
    <version>${json-io.version}</version>
</dependency>
```


```java
@Test
public void whenSerializeAndDeserializeUsingJsonio_thenCorrect(){
    Foo foo = new Foo(1,"first");

    String jsonStr = JsonWriter.objectToJson(foo);
    Foo result = (Foo) JsonReader.jsonToJava(jsonStr);
    assertEquals(foo.getId(),result.getId());
}

```

### Genson


```xml
<dependency>
    <groupId>com.owlike</groupId>
    <artifactId>genson</artifactId>
    <version>${genson.version}</version>
</dependency>
```


```java
@Test
public void whenSerializeAndDeserializeUsingGenson_thenCorrect(){
    Genson genson = new Genson();
    Foo foo = new Foo(1,"first");

    String jsonStr = genson.serialize(foo);
    Foo result = genson.deserialize(jsonStr, Foo.class);
    assertEquals(foo.getId(),result.getId());
}

```

[Content](#content)


## Java Examples

All examples are in /examples/src/main

### Annotations


Immutable Pojos
@JsonCreator – tell Jackson to use this constructor

@JsonProperty – which property the parameters binds to

```java

@JsonCreator
public ImmutableLoanApplication(
@JsonProperty("name") final String name,
...
```



@JsonIgnore  - Ignore Properties

```java

@JsonIgnore
public void setJobs(final Map<String, Job> jobs){
this.jobs = jobs;
}

```


@JsonProperty on a field - Rename Properties 

```java

@JsonProperty("name")
public String getApplicantName()
@JsonProperty("name")
private String applicantName;

```


@JsonProperty - Transform Properties

```java

@JsonProperty("jobs")
public void setJobsJson(final List<Job> jobs) {
this.jobs = jobs.stream()
.collect(toMap(Job::getTitle, job -> job));
}

```

### Custom Deserializers

```java
final LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE);

final SimpleModule module = new SimpleModule().addDeserializer(LocalDate.class, localDateDeserializer);

final ObjectMapper mapper = new ObjectMapper().registerModule(module);
```

### jetty server with servlets

All classes ended with `..Servlet` use this guide

for example `DomBankApplicationServlet`

Open git bash

`cd /examples/src/main/resources`

` ./post-bank-loan.sh bank_loan.json`

` ./post-bank-loan.sh bad_loan.json`


### jersey

run `JerseyBankApplication`

Open git bash

`cd /examples/src/main/resources`

` ./post-bank-loan.sh bank_loan.json`

` ./post-bank-loan.sh bad_loan.json`


### spring boot 

run app

Open git bash

`cd /examples/src/main/resources`

` ./post-bank-loan.sh bank_loan.json`

` ./post-bank-loan.sh bad_loan.json`


### Benchmark 

to run benchmark run `BenchmarkRunner` class

[Content](#content)


## JSON APIs

Java:

- Binding – simple, great default choice

- Tree/DOM – generic code that works on the whole document

- Streaming – highest performance code, lowest memory consumption


[Content](#content)



## JSON as a File Format

### Pros

- Human readable

- Tool support

- Easy to produce and consume

- Well understood

- Language/platform agnostic

### Cons

- No schema – type errors

- Inefficient for large documents

- Hard to concurrently access

[Content](#content)



## JSON problems

JSON’s popularity is mainly due to its
built-in support in web browsers (by virtue of being a subset of JavaScript) and sim‐
plicity relative to XML. 

problems:

• There is a lot of ambiguity around the encoding of numbers. 
JSON distinguishes strings and numbers, but it doesn’t distinguish integers and floating-point numbers, and it
doesn’t specify a precision.
This is a problem when dealing with large numbers; for example, integers greater
than 253 cannot be exactly represented in an IEEE 754 double-precision floatingpoint number, so such numbers become inaccurate when parsed in a language
that uses floating-point numbers (such as JavaScript). An example of numbers
larger than 253 occurs on Twitter, which uses a 64-bit number to identify each
tweet. The JSON returned by Twitter’s API includes tweet IDs twice, once as a
JSON number and once as a decimal string, to work around the fact that the
numbers are not correctly parsed by JavaScript applications.

• JSON has good support for Unicode character strings (i.e., humanreadable text), but it doesn’t support binary strings (sequences of bytes without
a character encoding). Binary strings are a useful feature, so people get around
this limitation by encoding the binary data as text using Base64. The schema is
then used to indicate that the value should be interpreted as Base64-encoded.
This works, but it’s somewhat hacky and increases the data size by 33%.

• There is optional schema support for JSON. These
schema languages are quite powerful, and thus quite complicated to learn and
implement. many JSON-based tools don’t bother using schemas. Since the correct interpretation of data (such
as numbers and binary strings) depends on information in the schema, applica‐
tions that don’t use JSON schemas need to potentially hardcode the appro‐
priate encoding/decoding logic instead.

Binary encoding
For data that is used only internally within your organization, there is less pressure to
use a lowest-common-denominator encoding format. For example, you could choose
a format that is more compact or faster to parse. For a small dataset, the gains are
negligible, but once you get into the terabytes, the choice of data format can have a
big impact.
JSON use a lot of space compared to binary formats. This observation led to the development of a profusion of binary encodings
for JSON (MessagePack, BSON, BJSON, UBJSON, BISON, and Smile, to name a few). These formats have been
adopted in various niches, but none of them are as widely adopted as the textual ver‐
sions of JSON.
Some of these formats extend the set of datatypes (e.g., distinguishing integers and
floating-point numbers, or adding support for binary strings), but otherwise they
keep the JSON data model unchanged. In particular, since they don’t prescribe
a schema, they need to include all the object field names within the encoded data.
That is, in a binary encoding of the JSON document in Example, they will need to
include the strings userName, favoriteNumber, and interests somewhere.

Example. Example record which we will encode in several binary formats in this
chapter
```json
{
 "userName": "Martin",
 "favoriteNumber": 1337,
 "interests": ["daydreaming", "hacking"]
}

```

The binary encoding is 66 bytes long, which is only a little less than the 81 bytes taken
by the textual JSON encoding (with whitespace removed). All the binary encodings of
JSON are similar in this regard. It’s not clear whether such a small space reduction
(and perhaps a speedup in parsing) is worth the loss of human-readability.
In the following sections we will see how we can do much better, and encode the
same record in just 32 bytes.

[Content](#content)


## Utils

https://jsonserve.com

https://jsonlint.com/#google_vignette

https://jsonformatter.org/json-pretty-print

https://jsonformatter.curiousconcept.com

[Content](#content)

