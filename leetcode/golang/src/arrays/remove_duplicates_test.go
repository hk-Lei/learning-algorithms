package arrays

import "testing"

func TestRemoveDuplicates(t *testing.T){
	cases := []struct{
		slice []int
		len int
	} {
		{[]int{1, 1, 2}, 2},
		{[]int{1, 1, 2, 2, 3}, 3},
		{[]int{1, 2}, 2},
		{[]int{}, 0},
	}

	for _,c := range cases{
		got := RemoveDuplicates(c.slice)

		if got != c.len {
			t.Errorf("RemoveDuplicates(%q) == %d, want %d", c.slice, got, c.len)
		}
	}
}