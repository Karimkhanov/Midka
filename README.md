# Midterm Exam Instructions

Midterm Exam is for Android course Students of KBTU Spring 2023-2024

## Installation

Use git clone command to fetch the project.

```bash
git clone https://github.com/estharossa/aviatickets.git
```

## About project

This project simulates an application for selling air tickets. The application has only one page for issuing tickets.

All necessary libraries are already registered in the build.gradle file.

Offer - class which holds an information about air ticket, including departure/arrival location, time, airline, duration and etc.

ApiClient - a Retrofit based http client. Use it for your network requests.


## Tasks

1. Offer list is taken from `FakeService` object, which is actually a list of hardcoded `Offer` objects. Add a GET request using Retrofit to fetch offer list from [here](https://my-json-server.typicode.com/estharossa/fake-api-demo/offer_list)
2. Offer list is displayed using Recycler View, but it uses not optimized method `notifyDataSetChanged()`. Add **Diff.Util** implementation for the recycler view and get rid of the "setItems" method
3. Add a functionality to sort offer list by **price and duration**. UI is already done for you using radio buttons, include only sorting logic and updating UI.

Bonus Task: add images of all airlines using Glide. There is already an ImageView for you.

## Submission

1. Make your repository **private** and include estharossa as a collaborator
2. Submit the [form](https://forms.gle/PK1pnQyXmxrCAwa99)

## License

[MIT](https://choosealicense.com/licenses/mit/)
