As we have setup a cascade ALL relationship from

Recipe -> Ingredient
Recipe -> Notes

Any changes on Recipe will therefore get passed down and reflected in Ingredient / Note

There is therefore no need to create repositories for them