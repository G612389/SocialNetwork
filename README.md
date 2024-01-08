<br/>
<p align="center">
  <h3 align="center">Social Network</h3>

  <p align="center">
    Social Network project assignment for Data Structures and Algorithms (DSA) course
    <br/>
    Universidad del País Vasco / Euskal Herriko Unibertsitatea
    <br/>
    <br/>
    <a href="https://github.com/G612389/SocialNetwork/issues">Report Bug</a>
    ·
    <a href="https://github.com/G612389/SocialNetwork/issues">Request Feature</a>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/G612389/SocialNetwork?color=dark-green) ![Issues](https://img.shields.io/github/issues/G612389/SocialNetwork) ![License](https://img.shields.io/github/license/G612389/SocialNetwork) [![Latest](https://img.shields.io/github/v/release/G612389/SocialNetwork)](RELEASE)

## Table Of Contents

* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Manual Compilation](#manual-compilation)
  * [Alternative](#alternative)
* [Contributing](#contributing)
* [License](#license)
* [Authors](#authors)

## Getting Started

To get a local copy of the project up and running follow these steps.

### Prerequisites

* Java Runtime Environment (JRE) or Java Development Kit (JDK)

  * [Java Downloads for All Operating Systems (JRE)](https://www.java.com/download/manual.jsp)
  * [Java Downloads | Oracle (JDK)](https://www.oracle.com/java/technologies/downloads/)


### Manual Compilation

1. Clone the repo

```sh
git clone https://github.com/G612389/SocialNetwork.git
```

2. Compile the Java classes

```sh
javac -d ./SocialNetwork/bin ./SocialNetwork/src/social_network/*.java
```

3. Build the JAR file
```sh
jar cfe ./SocialNetwork/SocialNetwork.jar social_network.Menu -C ./SocialNetwork/bin .
```

4. Execute the JAR file

```sh
java -jar ./SocialNetwork/SocialNetwork.jar
```

### Alternative

1. Download the latest release from the [Releases page](https://github.com/G612389/SocialNetwork/releases/latest).

2. Execute the JAR file

```sh
java -jar ./SocialNetwork.jar
```

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
* If you have suggestions for adding or removing projects, feel free to [open an issue](https://github.com/G612389/SocialNetwork/issues/new) to discuss it, or directly create a pull request after you edit the *README.md* file with necessary changes.
* Please make sure you check your spelling and grammar.
* Create individual PR for each suggestion.

### Creating A Pull Request

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the GNU General Public License v3.0 (or later). See [LICENSE](https://github.com/G612389/SocialNetwork/blob/main/LICENSE) for more information.

## Authors

* [Bartolumiu](https://github.com/Bartolumiu/)
* [DavoAGD](https://github.com/DavoAGD/)
* [G612389](https://github.com/G612389/)
