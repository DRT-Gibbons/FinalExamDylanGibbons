package com.example.finalexamjavadylangibbons;

public class Product {
  public int userId;
  public int id;
  public String title;
  public String body;

  @Override
  public String toString() {
    // Format the post data nicely for display in UI or console
    return "Post #" + id + " (User " + userId + "): " + title + "\n" + body;
  }
}
