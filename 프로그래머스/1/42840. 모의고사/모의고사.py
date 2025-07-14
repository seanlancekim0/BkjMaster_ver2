def solution(answers):
    answer = []
    list = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    count = [0, 0, 0]
    # for i in range(len(answers)):
    for i, ans in enumerate(answers):
        # for j in range(len(list)):
        for j, lst in enumerate(list):
            # if list[j][i%len(list[j])] == ans:
            if lst[i % len(lst)] == ans:
                count[j] += 1
    
    m = max(count)
    for i, key in enumerate(count):
        if key == m:
            answer.append(i+1)
    
    return answer