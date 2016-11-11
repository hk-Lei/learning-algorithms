package arrays

/*

 */
func RemoveDuplicates(slice []int) int{
	if len(slice) == 0 {
		return 0
	}

	index := 0
	for i := 1; i < len(slice); i++ {
		if slice[index] != slice[i] {
			index++
			slice[index] = slice[i]
		}
	}

	return index + 1
}