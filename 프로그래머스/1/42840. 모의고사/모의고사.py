def solution(answers):
    answer = []
    list = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    count = [0, 0, 0]
    
    for i, ans in enumerate(answers):
        for j, lst in enumerate(list):
            if lst[i % len(lst)] == ans:
                count[j] += 1
    
    for i, key in enumerate(count):
        if key == max(count):
            answer.append(i + 1)
    
    return answer