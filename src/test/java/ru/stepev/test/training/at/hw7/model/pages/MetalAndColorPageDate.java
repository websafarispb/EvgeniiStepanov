package ru.stepev.test.training.at.hw7.model.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class MetalAndColorPageDate {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalAndColorPageDate(List<String> list) {
        String[] summary = list.get(0).split(":");
        List<Integer> mySummary = Arrays.stream(summary[1].split(","))
                                        .map(String::trim)
                                        .map(Integer::valueOf)
                                        .collect(Collectors.toList());
        this.setSummary(mySummary);
        String[] elements = list.get(1).split(":");
        List<String> myElements = Arrays.stream(elements[1].split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
        this.setElements(myElements);
        String[] color = list.get(2).split(":");
        this.setColor(color[1].trim());
        String[] metal = list.get(3).split(":");
        this.setMetals(metal[1].trim());
        String[] vegetables = list.get(4).split(":");
        List<String> myVegetables = Arrays.stream(vegetables[1].split(","))
                                          .map(String::trim)
                                          .collect(Collectors.toList());
        this.setVegetables(myVegetables);
    }

    public void makeSummary() {
        List<Integer> currentSummary = new ArrayList<>();
        currentSummary.add(summary.stream().mapToInt(Integer::intValue).sum());
        setSummary(currentSummary);
    }
}
